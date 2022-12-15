package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import com.example.myapplication.databinding.ActivityMainBinding
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var retrofitInstance: ItemService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        retrofitInstance = RetrofitInstance
            .getRetrofitInstance()
            .create(ItemService::class.java)

        getAll()
    }

    private fun getAll(){
        binding.textView.text = ""
        val responseLiveData: LiveData<Response<ItemList>> = liveData {
            val response = retrofitInstance.getItems()
            emit(response)
        }

        responseLiveData.observe(this, Observer {
            val itemList = it.body()?.listIterator()
            if (itemList!=null){
                while (itemList.hasNext()){
                    val currentItem = itemList.next()
                    val result = " " + "item name: " + currentItem.name + "\n" +
                            " " + "category: " + currentItem.category + "\n"
                    binding.textView.append(result)
                }
            }
        })
    }
}