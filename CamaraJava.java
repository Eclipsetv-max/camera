import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;
import org.opencv.highgui.HighGui;

public class CamaraJava {
    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        VideoCapture camara = new VideoCapture(0);

        if (!camara.isOpened()) {
            System.out.println("No se pudo acceder a la cámara por exeso de bellesa lamentablementa causita.");
            return;
        }

        Mat frame = new Mat();
        System.out.println("📸 Cámara activada mi causa 🤑");

        while (true) {
            camara.read(frame);
            if (frame.empty()) break;

            HighGui.imshow("Vista de cámara", frame);
            if (HighGui.waitKey(30) == 27) break; // ESC para salir
        }

        camara.release();
        HighGui.destroyAllWindows();
        System.out.println("✅ Cámara cerrada.");
    }
}