package br.com.ifpb.pdm_0x5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var floatBtnAddColor: FloatingActionButton
    private lateinit var listViewColors: ListView
    private lateinit var listColors: ArrayList<ColorRGB>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.listColors = arrayListOf()

        this.listViewColors = findViewById(R.id.listViewColors)
        this.floatBtnAddColor = findViewById(R.id.floatBtnAddColor)

        this.listViewColors.adapter = ArrayAdapter<ColorRGB>(this, android.R.layout.simple_list_item_1, this.listColors)

        val colorResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if (it.resultCode == RESULT_OK){
                val color = it.data?.getSerializableExtra("COLOR") as ColorRGB
                (this.listViewColors.adapter as ArrayAdapter<ColorRGB>).add(color)
            }
        }

        this.floatBtnAddColor.setOnClickListener{
            val intent = Intent(this, FormColorActivity::class.java)
            colorResult.launch(intent)
        }
    }
}