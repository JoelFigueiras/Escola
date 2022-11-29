package com.example.escola

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.escola.adapter.Adapter
import com.example.escola.databinding.ActivityMainBinding
import com.example.escola.databinding.RowNotasBinding
import com.example.escola.modelData.UnidadeCurricular

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var unidadesCurriculares = ArrayList<UnidadeCurricular>()
    var getResult : ActivityResultLauncher<Intent>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        unidadesCurriculares.add(UnidadeCurricular("IA", 2022, 12.5))
        unidadesCurriculares.add(UnidadeCurricular("IA", 2022, 12.5))
        unidadesCurriculares.add(UnidadeCurricular("IA", 2022, 13.0))
        display(unidadesCurriculares)
        setContentView(binding.root)
    }

    fun display(array: ArrayList<UnidadeCurricular>) {
        val listView = binding.lvNotas
        val adapter = Adapter(this.baseContext, array)
        listView.adapter = adapter
        getResult =
            registerForActivityResult(
                ActivityResultContracts.StartActivityForResult()
            ) {
                if (it.resultCode == Activity.RESULT_OK) {
                    val bundle = it.data?.extras
                    val unidadeCurricular: UnidadeCurricular =
                        bundle?.getSerializable("unidadecurricular") as UnidadeCurricular
                    array.add(unidadeCurricular)
                    adapter.notifyDataSetChanged()
                }

            }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.unidadecurricular, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_nota -> {

                getResult?.launch(Intent(this, AddUnidadeCurricular::class.java))
                return true
            }
            R.id.action_media ->{
                var media :Double=0.0
                for(unidade in unidadesCurriculares)
                {
                    media+=unidade.nota
                }
                Toast.makeText(applicationContext,"media: ${media/unidadesCurriculares.size}",Toast.LENGTH_SHORT).show()

            }

        }
        return true
    }
}