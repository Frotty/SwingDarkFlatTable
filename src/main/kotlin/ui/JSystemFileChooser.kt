package ui

import javax.swing.JFileChooser
import javax.swing.LookAndFeel
import javax.swing.UIManager
import javax.swing.UnsupportedLookAndFeelException

class JSystemFileChooser : JFileChooser() {
    override fun updateUI() {
        var old: LookAndFeel? = UIManager.getLookAndFeel()
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName())
        } catch (ex: Throwable) {
            old = null
        }

        super.updateUI()

        if (old != null) {

            val background = UIManager.getColor("Label.background")
            setBackground(background)
            isOpaque = true

            try {
                UIManager.setLookAndFeel(old)
            } catch (ignored: UnsupportedLookAndFeelException) {
            }
            // shouldn't get here
        }
    }

}