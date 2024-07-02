package com.example.libraryapp

import com.example.libraryapp.BookGenreAdapter
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var todaysBookImage: ImageView
    private lateinit var todaysBookReadButton: Button

    private val genresWithBooks = mapOf(
        "Romance" to listOf(
            Book("A Reckless Heart", "Jennifer Wilck", "  ", "book_0007", "book_0007"),
            Book("Jane Eyre (Minimalist Classics)", "Charlotte Brontë", "  ", "book_0002", "book_0002"),
            Book("Fifty Shades of Grey", "E L James", "  ", "book_0003", "book_0003"),
            Book("Red, White & Royal Blue", "Casey McQuiston", "  ", "book_0001", "book_0001"),
            Book("The Finish Line", "Erica Lee", " ", "book_0008", "book_0008"),
            Book("Eleanor and Park", "Rainbow Rowell", "  ", "book_0004", "book_0004"),
            Book("The Proposal", "Jasmine Guillory", "  ", "book_0005", "book_0005"),
            Book("And Then I Met You", "Erica Lee", "   ", "book_0006", "book_0006"),
        ),
        "Fiction" to listOf(
            Book("All the Lights Above Us", "M.B. Henry", " ", "book_0015", "book_0015"),
            Book("The Gone & the Forgotten", "Clare Whitfield", "  ", "book_0009", "book_0009"),
            Book("The Girl on the Run", "Gregg Olsen", "  ", "book_0011", "book_0011"),
            Book("Such Fine Boys", "Patrick Modiano", "  " , "book_0012", "book_0012"),
            Book("The Lifeline", "Libby Page", "   ", "book_0013", "book_0013"),
            Book("Dryad's Blade", "Kater Cheek", "  ", "book_0010", "book_0010"),
            Book("Walt Disney's Goofy Movie Star", "Walt Disney", "  ", "book_0014", "book_0014")
        ),
        "Novel" to listOf(
            Book("Suzume", "Makoto Shinkai", "  ", "book_0016", "book_0016"),
            Book("Jujutsu Kaisen", "Gege Akutami", "  ", "book_0020", "book_0020"),
            Book("The Eminence in Shadow", "Author 10", "   ", "book_0017", "book_0017"),
            Book("Attack on Titan", "Hajime Isayama", "  ", "book_0021", "book_0021"),
            Book("Mushoku Tensei: Jobless Reincarnation Vol. 19", "Shirotaka", "  ", "book_0019", "book_0019"),
            Book("Moon Blossom Asura: The Ruthless Reincarnated Mercenary Forms the Ultimate Army", "Sou Hazuki", "  ", "book_0018", "book_0018"),
            Book("Naruto: Itachi’s Story, Vol. 1: Daylight", "Masashi Kishimoto", "   ", "book_0022", "book_0022"),
        ),
        "Mystery" to listOf(
            Book("Crimson Lake", "Candace Fox", "", "book_0023", "book_0023"),
            Book("Murder On The Orient Express", "Agatha Christie", "", "book_0024", "book_0024"),
            Book("Destination Unknown", "Agatha Christie", "", "book_0025", "book_0025"),
            Book("The Canterville Ghost", "Oscar Wilde", "", "book_0026", "book_0026"),
            Book("The Girl Before Me", "Laura Wolfe", "", "book_0027", "book_0027"),
            Book("The Killing Room", "John Manning", "", "book_0028", "book_0028"),
            Book("Appointment With Death", "Agatha Christie", "", "book_0029", "book_0029")
        ),
        "Physiological" to listOf(
            Book("Misery", "Stephen King", "", "book_0030", "book_0030"),
            Book("Gone Girl", "", "", "book_0031", "book_0031"),
            Book("The Paris Apartment", "Lucy Foley", "", "book_0032", "book_0032"),
            Book("The Woman In Cabin 10", "Ruth Ware", "", "book_0033", "book_0033"),
            Book("The Family Upstairs", "", "Lisa Jewell", "book_0034", "book_0034"),
            Book("What Lies Beyond the Woods", "Kate Alice Marshall", "", "book_0035", "book_0035"),
            Book("What Lies Beyond the Veil (Of Flesh and Bone, #1)", "Harper L. Woods", "", "book_0036", "book_0036"),
            Book("One by One", "Ruth Ware", "", "book_0037", "book_0037")
        ),
        "Science Fiction" to listOf(
            Book("Red Mars", "Kim Stanley Robinson", "", "book_0039", "book_0039"),
            Book("The Sirens Of Titan", "Kurt Vonnegurt", "", "book_0040", "book_0040"),
            Book("How to Live Safely in a Science Fictional Universe", "Charles Yu", "", "book_0042", "book_0042"),
            Book("Time War: Onslaught", "Nick S. Thomas", "", "book_0038", "book_0038"),
            Book("Low Chicago (Wild Cards)", "", "Wild Cards Trust", "book_0041", "book_0041"),
            Book("Exhalation: Stories", "", "Ted Chiang", "book_0043", "book_0043"),
            Book("Frankenstein", "Mary Shelley", "", "book_0044", "book_0044")
        ),
        "Historical Fiction" to listOf(
            Book("The Mirror Fractured Path", "J.C. Cervantes", "", "book_0049", "book_0049"),
            Book("The Winter Palace", "Paul Morgan", "", "book_0051", "book_0051"),
            Book("The Horseman", "Tim Pears", "", "book_0048", "book_0048"),
            Book("The Pillars of the Earth", "Ken Follett", "", "book_0045", "book_0045"),
            Book("All the Light We Cannot See", "Anthony Doerr", "", "book_0046", "book_0046"),
            Book("The Crimson Thread", "Kate Forsyth", "", "book_0047", "book_0047"),
            Book("Voices of the Dead", "Peter Leonard", "", "book_0050", "book_0050"),

        ),
        "Thriller" to listOf(
            Book("The Family Experiment", "John Marrs", "", "book_0053", "book_0053"),
            Book("The Winter Palace", "Paul Morgan", "", "book_0051", "book_0051"),
            Book("Every Move You Make", "C.L. Taylor", "", "book_0054", "book_0054"),
            Book("If Something Happens to Me", "Alex Finlay", "", "book_0052", "book_0052"),
            Book("The Wrong Sister", "Claire Douglas", "", "book_0055", "book_0055"),
            Book("A Lesson in Cruelty", "Harriet Tyce", "", "book_0056", "book_0056"),
            Book("The Trial", "Jo Spain", "", "book_0057", "book_0057")
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        todaysBookImage = findViewById(R.id.todaysBookImage)
        todaysBookReadButton = findViewById(R.id.todaysBookReadButton)

        // Randomly select a book for "Today's Book"
        val randomBook = genresWithBooks.values.flatten().random()
        val bookImageResId = resources.getIdentifier(randomBook.imageResourceName, "drawable", packageName)

        todaysBookImage.setImageResource(bookImageResId)
        todaysBookReadButton.setOnClickListener {
            openPdf(randomBook.pdfFileName)
        }

        setupGenreSections()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.navigationBarColor = resources.getColor(R.color.lightRed, theme)
        }
    }

    private fun openPdf(pdfFileName: String) {
        val intent = Intent(this, PdfViewerActivity::class.java)
        intent.putExtra("pdfName", pdfFileName)
        startActivity(intent)
    }

    // Inside MainActivity
    private fun openBookInfoActivity(book: Book) {
        val intent = Intent(this, BookInfoActivity::class.java)
        intent.putExtra("pdfName", book.pdfFileName)
        startActivity(intent)
    }


    private fun setupGenreSections() {
        val genresRecyclerViews = mapOf(
            "Romance" to findViewById<RecyclerView>(R.id.recyclerViewRomance),
            "Fiction" to findViewById<RecyclerView>(R.id.recyclerViewFiction),
            "Novel" to findViewById<RecyclerView>(R.id.recyclerViewNovel),
            "Mystery" to findViewById<RecyclerView>(R.id.recyclerViewMystery),
            "Physiological" to findViewById<RecyclerView>(R.id.recyclerViewPhysiological),
            "Science Fiction" to findViewById<RecyclerView>(R.id.recyclerViewScienceFiction),
            "Historical Fiction" to findViewById<RecyclerView>(R.id.recyclerViewHistoricalFiction),
            "Thriller" to findViewById<RecyclerView>(R.id.recyclerViewThriller)
        )

        genresWithBooks.forEach { (genre, books) ->
            setupRecyclerView(genresRecyclerViews[genre]!!, books, genre)
        }
    }

    private fun setupRecyclerView(recyclerView: RecyclerView, books: List<Book>, genre: String) {
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = BookGenreAdapter(books) { book ->
            openBookInfoActivity(book)
        }

        findViewById<Button>(resources.getIdentifier("btnShowAll${genre.replace(" ", "")}", "id", packageName)).setOnClickListener {
            val intent = Intent(this, ShowAllActivity::class.java)
            intent.putExtra("genre", genre)
            startActivity(intent)
        }
    }
}
