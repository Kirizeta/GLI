package com.example.gli

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ListActivity : AppCompatActivity() {
    private lateinit var db : DatabaseReference
    private lateinit var studentRecyclerView: RecyclerView
    private  lateinit var studentArrayList : ArrayList<User>
    private lateinit var backButton: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        studentRecyclerView = findViewById(R.id.studentlist)
        studentRecyclerView.layoutManager = LinearLayoutManager(this)
        studentRecyclerView.setHasFixedSize(true)
        backButton = findViewById(R.id.backButton)

        studentArrayList = arrayListOf<User>()
        getStudentData()

        backButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
    private fun getStudentData(){
        db = FirebaseDatabase.getInstance().getReference("StudentList")
        db.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (studentSnapshot in snapshot.getChildren()) {
                        val students = studentSnapshot.getValue(User::class.java)
                        studentArrayList.add(students!!)

                    }
                    studentRecyclerView.adapter = AdapterS(studentArrayList)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }


        })
    }


}