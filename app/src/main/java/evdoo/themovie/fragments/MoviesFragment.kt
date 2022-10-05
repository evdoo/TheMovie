package evdoo.themovie.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import evdoo.themovie.R

class MoviesFragment : Fragment() {

    private var movieClickListener: MovieClickListener? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_movies, container, false)

        val filmCard = view?.findViewById<View>(R.id.card_film)
        filmCard?.apply {
            setOnClickListener {
                movieClickListener?.onMovieClick()
            }
        }

        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is MovieClickListener) {
            movieClickListener = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        movieClickListener = null
    }

    interface MovieClickListener {
        fun onMovieClick()
    }
}