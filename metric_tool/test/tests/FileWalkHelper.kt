package dart_metrics

import java.io.File

internal object FileWalkHelper {
   fun File.getAllSubdirectoryFiles(): List<File> {
       return this.walkTopDown()
           .filter { it.isFile }
           .toList()
   }
}
