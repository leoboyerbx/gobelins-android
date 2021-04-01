package com.pnk.gobelins.neighbors

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.pnk.gobelins.neighbors.fragments.ListNeighborsFragment

class NeighborsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_neighbors)
        changeFragment(ListNeighborsFragment())

        findViewById<Button>(R.id.add_neighbor).setOnClickListener {
            // lancer une activité
            val intent = Intent(baseContext, AddNeighborActivity::class.java)
            startActivity(intent)

            // lancer une url
//            val url = Uri.parse("https://google.fr")
//            val intent = Intent(Intent.ACTION_VIEW, url)
//            startActivity(intent)

            // appeler un num
//            val url = Uri.parse("tel:0782078732")
//            val intent = Intent(Intent.ACTION_VIEW, url)
//            startActivity(intent)
        }
    }

    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            addToBackStack(null)
        }.commit()
    }
}
