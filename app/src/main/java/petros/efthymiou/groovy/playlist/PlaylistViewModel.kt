package petros.efthymiou.groovy.playlist

import androidx.lifecycle.*


class PlaylistViewModel (
    private val repository: PlaylistRepository
        ): ViewModel() {

    val loader = MutableLiveData<Boolean>()

    val playlists = liveData<Result<List<Playlist>>> {
        loader.postValue(true)

        emitSource(repository.getPlaylists().asLiveData())
    }

}
