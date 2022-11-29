package com.example.escola

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.escola.databinding.AddunidadecurricularBinding
import com.example.escola.modelData.UnidadeCurricular

class AddUnidadeCurricular:AppCompatActivity() {
    private lateinit var binding: AddunidadecurricularBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding = AddunidadecurricularBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.gravarButton.setOnClickListener{
            val unidade = UnidadeCurricular(binding.nomeEt.text.toString(), binding.anoEn.text.toString().toInt(), binding.notaIt.text.toString().toDouble())
            val bundle = Bundle()
            bundle.putSerializable("unidadecurricular",unidade)
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtras(bundle)
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}