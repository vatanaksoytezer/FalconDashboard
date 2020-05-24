package org.ghrobotics.falcondashboard.logger.charts

import javafx.scene.chart.LineChart
import javafx.scene.chart.NumberAxis
import javafx.scene.chart.XYChart
import org.ghrobotics.falcondashboard.FalconDs.RPM
import org.ghrobotics.falcondashboard.FalconDs.matchTime
import javafx.application.Platform;
import org.ghrobotics.falcondashboard.ui


object RPMChart : LineChart <Number,Number>(
        NumberAxis(),
        NumberAxis()
) {
    private val dataList = XYChart.Series<Number,Number>()
    private val WINDOW_SIZE = 100

    init{
        this.animated = false
        data.add(dataList)
        update()
    }
    public fun update()
    {

        ui {
            dataList.data.add(Data(matchTime, RPM))

            if (dataList.data.size > WINDOW_SIZE) {
                dataList.data.removeAt(0);
            }
        }

    }
}
