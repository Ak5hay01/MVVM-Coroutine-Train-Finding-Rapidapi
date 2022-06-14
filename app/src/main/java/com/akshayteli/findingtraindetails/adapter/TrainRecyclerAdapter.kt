package com.akshayteli.findingtraindetails.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.akshayteli.findingtraindetails.R
import com.akshayteli.findingtraindetails.model.Days
import com.akshayteli.findingtraindetails.model.TrainDetailsItem

/**
 * Created by Akshay Teli on 10,June,2022
 */
class TrainRecyclerAdapter:RecyclerView.Adapter<TrainRecyclerAdapter.TrainItemViewHolder>() {

    var lstData = ArrayList<TrainDetailsItem>()

    fun setListData(data: ArrayList<TrainDetailsItem>?){

        if (data != null) {
            this.lstData = data
        }
        else{
            lstData = ArrayList<TrainDetailsItem>()
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TrainRecyclerAdapter.TrainItemViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.train_item,parent,false)
        return TrainItemViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: TrainItemViewHolder, position: Int) {
        holder.bind(lstData[position])
    }

    override fun getItemCount(): Int {
        return lstData.size
    }

    class TrainItemViewHolder(view: View):RecyclerView.ViewHolder(view){

        val txtTrainName = view.findViewById<TextView>(R.id.txtTrainName)
        val txtFromTrain = view.findViewById<TextView>(R.id.txtFromDesc)
        val txtToTrain = view.findViewById<TextView>(R.id.txtToDesc)
        val txtArrivalTrain = view.findViewById<TextView>(R.id.txtArrivalDesc)
        val txtDepartureTrain = view.findViewById<TextView>(R.id.txtDepartureDesc)
        val txtDay = view.findViewById<TextView>(R.id.txtDayDesc)
        val txtClassTrain = view.findViewById<TextView>(R.id.txtClassDesc)


        fun bind(trainDetailsItem: TrainDetailsItem) {
            txtTrainName.text = trainDetailsItem.name
            txtFromTrain.text=trainDetailsItem.trainFrom
            txtToTrain.text=trainDetailsItem.trainTo
            txtArrivalTrain.text=trainDetailsItem.data.arriveTime
            txtDepartureTrain.text = trainDetailsItem.data.departTime
            txtDay.text= checkWhenRuns(trainDetailsItem.data.days)
            txtClassTrain.text = trainDetailsItem.data.classes.toString().replace("[", " ").replace("]"," ")

        }

        private fun checkWhenRuns(days: Days):String {

            var presentDays = ""

               if(days.mon.toString() == "1.0"){
                   presentDays += "Mon "
               }
              if(days.tue.toString() == "1.0"){
                   presentDays += " Tue "
               }
               if(days.wed.toString() == "1.0"){
                   presentDays += " Wed "
               }
               if(days.thu.toString() == "1.0"){
                   presentDays += " Thu "
               }
               if(days.fri.toString() == "1.0"){
                   presentDays += " Fri "
               }
               if(days.sat.toString() == "1.0"){
                   presentDays += " Sat "
               }
               if(days.sun.toString() == "1.0"){
                   presentDays += " Sun "
               }

            return presentDays
        }

    }



}