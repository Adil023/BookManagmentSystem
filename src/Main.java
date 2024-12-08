import library.service.Library;
import library.service.RunableMyService;

import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException {
        RunableMyService obj = new Library();

        obj.menu();
    }}
