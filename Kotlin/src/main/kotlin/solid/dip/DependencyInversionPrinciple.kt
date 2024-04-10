/*
* 
* Kotlin
* 
* @Author : Jerry Okafor 
* @Date : 07/08/2023
*/

package solid.dip

interface DIPDataSource {
    fun getData(): String
}

class RemoteDataSource : DIPDataSource {
    override fun getData(): String = "Data from remote data source"
}

class LocalDataSource : DIPDataSource {
    override fun getData(): String = "Data from local data source"

}

interface Repository{
    fun getData():String
}

class RepositoryImpl(private val remoteDataSource: DIPDataSource, private val localDataSource: DIPDataSource):
    Repository {
    private val hasNetwork = false
    override fun getData() = if (hasNetwork) remoteDataSource.getData() else localDataSource.getData()
}