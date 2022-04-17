package es.uniovi.networkapp

import android.net.ConnectivityManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.google.android.material.snackbar.Snackbar
import es.uniovi.networkapp.databinding.ActivityMainBinding
import es.uniovi.networkapp.domain.BusStopsViewModel
import es.uniovi.networkapp.ui.BusStatusListAdapter
import es.uniovi.networkapp.ui.StopsUIState

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val busStatusListAdapter : BusStatusListAdapter = BusStatusListAdapter()
    private val busStopsViewModel : BusStopsViewModel = BusStopsViewModel()
    private val refreshListener = SwipeRefreshLayout.OnRefreshListener { busStopsViewModel.getBusStopsList() }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        /*binding.button.setOnClickListener {
            if (!isOnline()){
                Toast.makeText(this@MainActivity, "not conected", Toast.LENGTH_SHORT).show()
            }
            else Toast.makeText(this@MainActivity, "conected :)", Toast.LENGTH_SHORT).show()
            busStopsViewModel.getBusStopsList()
        }*/
        binding.swiper.setOnRefreshListener(refreshListener)
        busStopsViewModel.stopsUIStateObservable.observe(this) { result ->
            when (result) {
                is StopsUIState.Success -> {
                    busStatusListAdapter.submitList(result.llegadas.llegada)
                    binding.swiper.isRefreshing = false
                }
                is StopsUIState.Error -> {
                    Snackbar.make(binding.root, result.message, Snackbar.LENGTH_LONG).show()
                    binding.swiper.isRefreshing = false
                }
                is StopsUIState.Loading -> {
                    binding.swiper.isRefreshing = true
                }
            }
        }
        binding.recyclerview.adapter = busStatusListAdapter
        binding.recyclerview.layoutManager = LinearLayoutManager(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.menu_action, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        when(item.itemId) {
            R.id.refresh ->  {
                Toast.makeText(this@MainActivity, "en teoria se acutualizaria xd", Toast.LENGTH_SHORT).show()
                busStopsViewModel.getBusStopsList()
            }
        }
        return true
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun isOnline():Boolean {
        val connectivityManager = getSystemService(ConnectivityManager::class.java)
        val currentNetwork = connectivityManager.activeNetwork
        if (currentNetwork != null)
            return true
        return false
    }
}