package org.ghrobotics.falcondashboard.logger

import org.ghrobotics.falcondashboard.logger.charts.RPMChart
import tornadofx.View
import tornadofx.vbox

class LoggerView : View() {
    override val root = vbox {
        add(RPMChart)
    }
}