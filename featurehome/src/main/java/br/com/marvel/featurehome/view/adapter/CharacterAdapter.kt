package br.com.marvel.featurehome.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.marvel.core.network.responses.CharacterResponse
import coil.api.load
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.textview.MaterialTextView
import com.marvel.featurehome.R


class CharacterAdapter(val characteres: List<CharacterResponse>,val listener:OnClickCharacter) :
    RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    interface OnClickCharacter {
        fun onClick(idCharacter : Long?)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CharacterViewHolder {
        return CharacterViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_adapter_character,
                parent,
                false
            )
        )
    }



    override fun getItemCount() = characteres.size

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(characteres[position])
    }

    inner class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val ivThumbnail: AppCompatImageView = itemView.findViewById(R.id.iv_thumbnail)
        val mtvNameCharacter: MaterialTextView = itemView.findViewById(R.id.mtv_name_character)
        val clContainer: ConstraintLayout = itemView.findViewById(R.id.cl_container)

        fun bind(character: CharacterResponse) {
            ivThumbnail.load("${character.thumbnail.path}.${character.thumbnail.extension}")
            mtvNameCharacter.text = character.name
            itemView.setOnClickListener {
                listener.onClick(character.id)
            }
        }
    }
}