package com.example.escola.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.core.content.ContextCompat.getColor
import com.example.escola.R
import com.example.escola.databinding.RowNotasBinding
import com.example.escola.modelData.UnidadeCurricular

class Adapter(val context: Context, val unidadesCurriculares : ArrayList<UnidadeCurricular>) : BaseAdapter() {
    override fun getCount(): Int {
        return unidadesCurriculares.size
    }

    override fun getItem(p0: Int): Any {
       return unidadesCurriculares[p0]
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val binding = RowNotasBinding.inflate(LayoutInflater.from(context),p2,false)
        binding.tvNome.text = unidadesCurriculares[p0].nome
        binding.tvAno.text = unidadesCurriculares[p0].ano.toString()
        binding.tvNota.text = unidadesCurriculares[p0].nota.toString()
        if(unidadesCurriculares[p0].nota <=9.5)
        {
            binding.tvNota.setTextColor(getColor(context,R.color.purple_500))
        }
        return binding.root

    }
}