package pl.dawidbasa.fileFinder;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import pl.dawidbasa.EmployeSalarySorting.Employee;

public class FileFinder {
	
	/* #########################################################################
	 *  Korzystaj¹c z metod listFiles(FileFilter) i isDirectory z klasy
	 * java.io.File, napisz metodê zwracaj¹c¹ wszystkie podkatalogi wskazanego
	 * katalogu. Wykorzystaj wyra¿enie lambda zamiast obiektu FileFilter. /*
	 * #########################################################################
	 * Korzystaj¹c z metody list(FilenameFilter) klasy java.io.File,
	 * napisz metodê zwracaj¹c¹ wszystkie pliki ze wskazanego katalogu ze
	 * wskazanym rozszerzeniem. U¿yj wyra¿enia lambda, a nie FilenameFilter
	   #########################################################################
	 * Maj¹c listê obiektów File, posortuj je w taki sposób, by katalogi
	 * znalaz³y siê przed plikami, a w ka¿dej grupie elementy zosta³y
	 * posortowane wed³ug nazwy. U¿yj wyra¿enia lambda przy implementowaniu
	 * interfejsu Comparator.*/
	 

	// Find all subdirectories of selected directory
	static List<File> findAllSubDirectories(String path) {
		File folder = new File(path);
		return Arrays.asList(folder.listFiles(File::isDirectory));
	}

	// Find all files with selected extension
	static List<File> findFilesWithExtension(String path, String extension) {
		File folder = new File(path);
		
		List<File> files = Arrays.asList(folder.listFiles((File dir, String name) -> name.endsWith(extension)))
				.stream()
				.filter(File::isFile)
				.collect(Collectors.toList());
		
		return files;
	}	

	static List<File> findAllFilesAndFolders(String path){
		File folder = new File(path);
		
		return Arrays.asList(folder.listFiles());
		
	}
	// sort files first folders then files
    static List<File> sortFilesAndFolders(List<File> files){
    	files.sort(Comparator.comparing(File::isFile));
		return files;
	}
	
	public static void main(String args[]) {
		System.out.println("Find all folders");
		findAllSubDirectories("g:/").forEach(System.out::println);
		
		System.out.println("####################################################################");
		System.out.println("Find all files with extension");
		findFilesWithExtension("g:/", "info").forEach(System.out::println);
		
		System.out.println("####################################################################");
		System.out.println("sort first folders then files");
		sortFilesAndFolders(findAllFilesAndFolders("g:/")).forEach(System.out::println);;
	}
}
