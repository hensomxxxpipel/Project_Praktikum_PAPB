package com.example.praktikum1

import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class ToDoRepository {
    private val db = FirebaseFirestore.getInstance()

    suspend fun addToDoItem(item: ToDoItem) {
        db.collection("todos")
            .document(item.id)
            .set(item)
            .await()
    }

    suspend fun getToDoItems(): List<ToDoItem> {
        val result = db.collection("todos").get().await()
        return result.documents.mapNotNull { doc ->
            doc.toObject(ToDoItem::class.java)
        }
    }

    suspend fun updateToDoItem(item: ToDoItem) {
        db.collection("todos")
            .document(item.id)
            .set(item)
            .await()
    }

    suspend fun deleteToDoItem(id: String) {
        db.collection("todos").document(id).delete().await()
    }
}