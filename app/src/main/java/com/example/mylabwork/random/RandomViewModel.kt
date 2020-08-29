package com.example.mylabwork.random

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mylabwork.network.DevLifeApi
import com.example.mylabwork.network.DevLifeProperty
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

enum class DevLifeApiStatus { LOADING, ERROR, DONE }

class RandomViewModel : ViewModel() {



    private val _index = MutableLiveData<Int>()

    fun setIndex(index: Int) {
        _index.value = index
    }

    private val _status = MutableLiveData<DevLifeApiStatus>()

    val status: LiveData<DevLifeApiStatus>
        get() = _status


    private val _property = MutableLiveData<DevLifeProperty>()

    val property: LiveData<DevLifeProperty>
        get() = _property


   private val _properties = MutableLiveData<MutableList<DevLifeProperty>>()

   val properties: LiveData<MutableList<DevLifeProperty>>
       get() = _properties



    private var viewModelJob = Job()


    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)


    init {
        getDevLifeProperty()
    }

    private fun getDevLifeProperty() {
        coroutineScope.launch {

            var getPropertyDeferred = DevLifeApi.retrofitService.getPropertyAsync()
            try {
                _status.value =
                    DevLifeApiStatus.LOADING

                val result = getPropertyDeferred.await()
                _status.value =
                    DevLifeApiStatus.DONE
                _property.value = result
                _properties.value?.add(result)
            } catch (e: Exception) {
                _status.value =
                    DevLifeApiStatus.ERROR
                _property.value = null
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    fun onNext() {
       getDevLifeProperty()

   }

    fun onBack() {
        if (_properties.value!!.size != 0) {
                _property.value = _properties.value!![_properties.value!!.size]
        }
    }


}