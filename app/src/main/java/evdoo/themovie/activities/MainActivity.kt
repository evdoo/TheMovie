package evdoo.themovie.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import evdoo.themovie.R
import evdoo.themovie.fragments.MoviesDetailsFragment
import evdoo.themovie.fragments.MoviesFragment

class MainActivity: AppCompatActivity(), MoviesFragment.MovieClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragments_frame, MoviesFragment())
                .commit()
        }
    }

    override fun onMovieClick() {
        supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(R.id.fragments_frame, MoviesDetailsFragment())
            .commit()
    }
}