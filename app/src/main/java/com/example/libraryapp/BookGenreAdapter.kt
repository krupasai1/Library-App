package com.example.libraryapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BookGenreAdapter(private val books: List<Book>, private val onItemClick: (Book) -> Unit) :
    RecyclerView.Adapter<BookGenreAdapter.BookViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.book_item_genre, parent, false)
        return BookViewHolder(view)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = books[position]
        holder.bind(book)
        holder.itemView.setOnClickListener { onItemClick(book) }
    }

    override fun getItemCount(): Int {
        return books.size
    }

    class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val bookImage: ImageView = itemView.findViewById(R.id.bookImage)
        private val bookTitle: TextView = itemView.findViewById(R.id.bookTitle)

        fun bind(book: Book) {
            bookImage.setImageResource(itemView.context.resources.getIdentifier(book.imageResourceName, "drawable", itemView.context.packageName))
            bookTitle.text = truncateTitle(book.title)
        }

        private fun truncateTitle(title: String): String {
            val maxChars = 14 // Adjust according to your layout needs
            return if (title.length > maxChars) {
                title.take(maxChars) + "..."
            } else {
                title
            }
        }
    }
}