package com.example.praktikum1

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.UUID

class ToDoViewModel : ViewModel() {
    private val repository = ToDoRepository()

    private val _toDoList = MutableStateFlow<List<ToDoItem>>(emptyList())
    val toDoList: StateFlow<List<ToDoItem>> = _toDoList

    fun loadToDoItems() {
        viewModelScope.launch {
            val items = repository.getToDoItems()
            _toDoList.value = items
        }
    }

    fun addToDoItem(title: String, description: String) {
        val newItem = ToDoItem(
            id = UUID.randomUUID().toString(),
            title = title,
            description = description,
            isDone = true
        )
        viewModelScope.launch {
            repository.addToDoItem(newItem)
            loadToDoItems()
        }
    }

    fun updateToDoItem(updatedItem: ToDoItem) {
        viewModelScope.launch {
            repository.updateToDoItem(updatedItem)
            loadToDoItems()
        }
    }

    fun deleteToDoItem(item: ToDoItem) {
        viewModelScope.launch {
            repository.deleteToDoItem(item.id)
            loadToDoItems()
        }
    }
}