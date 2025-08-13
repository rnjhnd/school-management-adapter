public class LibrarySystemAdapter implements SchoolManagementApp {
    private final LibrarySystem librarySystem;

    public LibrarySystemAdapter(LibrarySystem librarySystem) {
        this.librarySystem = librarySystem;
    }

    @Override
    public String integrateSystem() {
        return librarySystem.manageBooks();
    }
}