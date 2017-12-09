import tablelayout.Table
import ui.SetupButton
import ui.UiStyle
import java.awt.Color
import java.awt.EventQueue
import javax.swing.JFrame
import javax.swing.JTextField
import javax.swing.WindowConstants

class SwingTest : JFrame() {
    init {
        title = "SwingTest"
        setSize(640, 480)
        setLocationRelativeTo(null)
        defaultCloseOperation = WindowConstants.DISPOSE_ON_CLOSE
        background = Color(36, 36, 36)
        isVisible = true

        contentPane.background = Color(36, 36, 36)


        val button1 = SetupButton("One")
        val button2 = SetupButton("Two")
        val button3 = SetupButton("Three")
        val button4 = SetupButton("Four")
        val button5 = SetupButton("Five")
        val text1 = JTextField("One")
        val text2 = JTextField("Two")
        val text3 = JTextField("Three")

        val table = Table()
        contentPane.add(table)

        table.addCell(button1)
        table.addCell(button2)
        table.row()
        table.addCell(button3).colspan(2)
        table.row()
        table.addCell(text1).colspan(2).fill()
        table.row()
        table.addCell(text2).right().width(150f)
        table.addCell(text3).width(250f)
        table.row()
        table.addCell(button4).expand().colspan(2)
        UiStyle.setStyle(table)
        table.debug()
    }

    companion object {

        @Throws(Exception::class)
        @JvmStatic
        fun main(args: Array<String>) {
            EventQueue.invokeLater { SwingTest() }
        }
    }
}