package ui

import tablelayout.Table
import java.awt.Color
import javax.swing.*
import javax.swing.border.CompoundBorder
import javax.swing.border.EmptyBorder
import javax.swing.plaf.basic.BasicProgressBarUI


object UiStyle {

    fun setStyle(table: Table) {
        for (i in 0 until table.components.size) {
            val component = table.components[i]
            if (component is JTextField) {
                component.setBackground(Color(46, 46, 46))
                component.setForeground(Color(255, 255, 255))
                val line = BorderFactory.createEtchedBorder()
                val pad = EmptyBorder(0, 5, 0, 0)
                val compoundBorder = CompoundBorder(line, pad)
                (component as JComponent).border = compoundBorder
            } else if (component is JProgressBar) {
                component.border = BorderFactory.createLineBorder(Color(80, 80, 80))
                component.foreground = Color(101, 108, 142)
                component.background = Color(36, 36, 36)
                component.isStringPainted = false
                component.setUI(BasicProgressBarUI())
            } else if (component is Table) {
                setStyle(component)
            }
            (component as? JLabel)?.foreground = Color.WHITE
        }
    }

}
