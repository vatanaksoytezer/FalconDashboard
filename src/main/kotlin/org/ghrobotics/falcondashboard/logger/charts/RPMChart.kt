package org.ghrobotics.falcondashboard.logger.charts

import javafx.scene.chart.LineChart
import javafx.scene.chart.NumberAxis
import javafx.scene.chart.XYChart
import org.ghrobotics.falcondashboard.FalconDs.RPM
import org.ghrobotics.falcondashboard.FalconDs.matchTime
import org.ghrobotics.falcondashboard.Network
import org.ghrobotics.falcondashboard.generator.charts.VelocityChart
import kotlin.math.absoluteValue

object RPMChart : LineChart <Number,Number>(
        NumberAxis(),
        NumberAxis()
) {
    private val dataList = XYChart.Series<Number,Number>()
    init{
        data.clear()
        update()
    }
    public fun update(){
        dataList.data.add(Data(matchTime, RPM))
        data.clear()
        data.add(dataList)
    }
}