package br.com.ifpb.pdm_0x5
import java.io.Serializable

class ColorRGB (var red: Int, var blue: Int, var green: Int): Serializable {
    override fun toString(): String {
        return "$red, $blue, $green"
    }
}
