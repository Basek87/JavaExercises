package pl.dawidbasa.fileFinder;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class FileFinder {
	/* ##############################################################################
	 * Korzystaj¹c z metod listFiles(FileFilter) i isDirectory z klasy
	 * java.io.File, napisz metodê zwracaj¹c¹ wszystkie podkatalogi wskazanego
	 * katalogu. Wykorzystaj wyra¿enie lambda zamiast obiektu FileFilter.
	/* ##############################################################################
	 * Korzystaj¹c z metody list(FilenameFilter) klasy java.io.File, napisz
	 * metodê zwracaj¹c¹ wszystkie pliki ze wskazanego katalogu ze wskazanym
	 * rozszerzeniem. U¿yj wyra¿enia lambda, a nie FilenameFilter
	 */
	// ##############################################################################

	// Find all subdirectories of selected directory
	static List<File> findAllSubDirectories(String path) {
		File folder = new File(path);
		return Arrays.asList(folder.listFiles(File::isDirectory));
	}

	// Find all files with selected extension
	static List<String> findFilesWithExtension(String path, String extension) {
		File folder = new File(path);
		return Arrays.asList(folder.list((File dir, String name) -> name.endsWith(extension)));
	}

	public static void main(String args[]) {
		findAllSubDirectories("c:/").forEach(System.out::println);
		findFilesWithExtension("d:/", ".txt").forEach(System.out::println);
	}
}
