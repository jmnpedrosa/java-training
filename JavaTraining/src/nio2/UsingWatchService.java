package nio2;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;
import static java.nio.file.StandardWatchEventKinds.OVERFLOW;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

/*
 * A Demonstration of using the WatchService to listen for changes in the
 * contents of a given path in the file system
 */

public class UsingWatchService {

  public static void main(String[] args) {
    WatchService watchService = null;

    try {
      // Create a WatchService and register multiple paths to it,
      // listening to different events.
      watchService = FileSystems.getDefault().newWatchService();
      Path dir1 = Paths.get("D:\\mydir\\");
      Path dir2 = Paths.get("D:\\mydir\\subdir");

      dir1.register(watchService, ENTRY_MODIFY, ENTRY_DELETE, ENTRY_CREATE);
      dir2.register(watchService, ENTRY_DELETE);
      
      WatchKey watchKey = null;
      
      // Listening for events in an endless loop
      while(true) {
        // take() will block code executions and wait for the next key
        watchKey = watchService.take();
        // Retrieve all pending events present in this key.
        for (WatchEvent<?> watchEvent : watchKey.pollEvents()) {
          
          WatchEvent.Kind<?> kind = watchEvent.kind();
          Path path = ((WatchEvent<Path>) watchEvent).context();
          
          if (kind == OVERFLOW) {
            continue;
          } else if (kind == ENTRY_CREATE) {
            System.out.format("\nCreate - %s", path);
          } else if (kind == ENTRY_MODIFY) {
            System.out.format("\nModify - %s", path);
          } else if (kind == ENTRY_DELETE) {
            System.out.format("\nDelete - %s", path);
          }
        }
        if (!watchKey.reset()) break;
      }
      
    } catch (IOException ioe) {
      System.out.println(ioe.toString());
    } catch (InterruptedException ioe) {
      System.out.println(ioe.toString());
    } finally {
      try {
        watchService.close();
      } catch (IOException e) {
        System.out.println(e);
      }
    }
  }

}
