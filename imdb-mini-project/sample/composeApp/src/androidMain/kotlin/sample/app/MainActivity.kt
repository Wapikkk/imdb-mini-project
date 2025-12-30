package sample.app
import android.os.Bundle
import moe.tlaster.precompose.lifecycle.setContent
import moe.tlaster.precompose.viewmodel.viewModel
import moe.tlaster.precompose.lifecycle.PreComposeActivity
import com.wapekk.imdb.repository.MovieRepository
import com.wapekk.imdb.viewModel.ViewModelMovies

class MainActivity : PreComposeActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val repository = MovieRepository()

        setContent {
            val viewModel = viewModel(ViewModelMovies::class) {
                ViewModelMovies(repository)
            }
            MovieApp()
        }
    }
}