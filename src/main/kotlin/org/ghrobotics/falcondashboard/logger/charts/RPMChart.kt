package org.ghrobotics.falcondashboard.logger.charts

import javafx.scene.chart.LineChart
import javafx.scene.chart.NumberAxis
import javafx.scene.chart.XYChart
import org.ghrobotics.falcondashboard.FalconDs.RPM
import org.ghrobotics.falcondashboard.FalconDs.matchTime
import org.ghrobotics.falcondashboard.ui


object RPMChart : LineChart <Number,Number>(
        NumberAxis(),
        NumberAxis()
) {
    private val dataList = XYChart.Series<Number,Number>()
    private val WINDOW_SIZE = 10

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
            setAxisBounds(this, dataList.data[0].xValue.toDouble(),
                dataList.data[dataList.data.lastIndex].xValue.toDouble()*1.0, true)
        }

    }

    fun setAxisBounds(
        myChart: RPMChart,
        min: Double,
        max: Double,
        isXAxis: Boolean
    ) {
        val axis: NumberAxis
        axis = if (isXAxis) myChart.xAxis as NumberAxis else myChart.yAxis as NumberAxis
        axis.isAutoRanging = false
        axis.lowerBound = min
        axis.upperBound = max
    }
}
