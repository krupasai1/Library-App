package com.example.libraryapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BookAdapter(
    private val bookList: List<Book>,
    private val onBookClick: (Book) -> Unit
) : RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    class BookViewHolder(itemView: View, private val onBookClick: (Book) -> Unit) : RecyclerView.ViewHolder(itemView) {
        private val bookImageView: ImageView = itemView.findViewById(R.id.bookImageView)
        private val bookTitleTextView: TextView = itemView.findViewById(R.id.bookTitleTextView)
        private val bookAuthorTextView: TextView = itemView.findViewById(R.id.bookAuthorTextView)
        private val bookDescriptionTextView: TextView = itemView.findViewById(R.id.bookDescriptionTextView)

        fun bind(book: Book) {
            val bookImageResId = itemView.context.resources.getIdentifier(book.imageResourceName, "drawable", itemView.context.packageName)
            bookImageView.setImageResource(bookImageResId)
            bookTitleTextView.text = book.title
            bookAuthorTextView.text = book.author
            bookDescriptionTextView.text = truncateDescription(book.description)

            itemView.setOnClickListener {
                onBookClick(book)
            }
        }

        private fun truncateDescription(description: String): String {
            val maxWords = 20 // Adjust according to your layout needs
            val words = description.split(" ")
            val truncated = words.take(maxWords).joinToString(" ")
            return if (words.size > maxWords) "$truncated..." else truncated
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.book_item, parent, false)
        return BookViewHolder(itemView, onBookClick)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bind(bookList[position])
    }

    override fun getItemCount() = bookList.size
}


