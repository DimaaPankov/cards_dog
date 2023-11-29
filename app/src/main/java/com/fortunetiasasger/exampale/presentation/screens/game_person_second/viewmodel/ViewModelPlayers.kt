package com.fortunetiasasger.exampale.presentation.screens.game_person_second.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fortunetiasasger.exampale.data.models.Person
import com.fortunetiasasger.exampale.data.repository.StaticDataApi
import com.fortunetiasasger.exampale.data.repository.StaticDate
import com.fortunetiasasger.exampale.presentation.activity.MainActivity
import com.fortunetiasasger.exampale.presentation.nav.Screen

class ViewModelPlayers(val date: StaticDataApi) : ViewModel() {
    val titleNow = MutableLiveData(if(StaticDate.personNow== Person.ONE){
        date.nameFirst //viewModel.textPlayerOne.observeAsState("").value
    }else{
        date.nameSecond //  viewModel.textPlayerTwo.observeAsState("").value
    })
 //   val textPlayerOne= MutableLiveData(date.nameFirst)
 //   val textPlayerTwo= MutableLiveData(date.nameSecond)
  private  fun changePlayerOne(newText:String){
        date.nameFirst = if(date.nameFirst == "First person")
        {""}
        else
        {newText}
     titleNow.value =  date.nameFirst
    }

  private  fun changePlayerSecond(newText:String){
        date.nameSecond = if(date.nameSecond == "Second person")
        {""}
        else
        {newText}
        titleNow.value =  date.nameSecond
    }

    val changeNameNow = {
        str:String ->
        if(StaticDate.personNow == Person.ONE){
            changePlayerOne(str)
        }else{
            changePlayerSecond(str)

        }
    }


    fun clickedStart(){
        MainActivity.navController.navigate(Screen.ScreenStartSession.route)
    }
}