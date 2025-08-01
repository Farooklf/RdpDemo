package com.print_demo

import CTOS.CtPrint
import android.graphics.Bitmap

public class RDPTest {
    val TAG: String = "Saturn1000 Print demo"

    val print: CtPrint = CtPrint()

    val print_x: Int = 0
    val print_y: Int = 36
    val Currently_high: Int = 20
    val ret: Int = 0
    val bitmap: Bitmap? = null


    //        print.initPage(200);
//        bitmap = print.encodeToBitmap("12ASDFSS34", print.QR_CODE, 150, 150);
//        print.drawImage(bitmap, 0, 0);
//        print.printPage();
//
//        ret = print.roll(10);
//        Log.d(TAG, String.format("Roll ret = %d", ret));
//
//        ret = print.status();
//        Log.d(TAG, String.format("status ret = %d", ret));
//
//        print.setHeatLevel(2);


    /**
     * Prints text using the CtPrint library.
     *
     * This function demonstrates how to use the `CtPrint` library to print text with various formatting options.
     *
     * Library Analysis:
     * The `CTOS.CtPrint` library is used for interacting with a printer.
     * Key methods used:
     * - `print.initPage(height: Int)`: Initializes a new print page with the specified height in dots.
     * - `print.drawText(x: Int, y: Int, text: String, fontSize: Int, fontStyle: Int, isBold: Boolean, rotation: Float, isUnderline: Boolean, isReverse: Boolean)`:
     *   Draws text on the current page.
     *     - `x`: The x-coordinate of the starting point of the text.
     *     - `y`: The y-coordinate of the starting point of the text.
     *     - `text`: The string to be printed.
     *     - `fontSize`: The size of the font. The library seems to interpret this differently, possibly as a predefined font style or size index rather than point size.
     *                  In this example, `print_y` (which is 36) is used, suggesting it might correspond to a specific font height or style.
     *     - `fontStyle`: An integer representing the font style. '1' is used here, its specific meaning would be defined by the CtPrint library documentation.
     *     - `isBold`: Boolean, true if the text should be bold.
     *     - `rotation`: Float, the rotation angle of the text. 0f means no rotation.
     *     - `isUnderline`: Boolean, true if the text should be underlined.
     *     - `isReverse`: Boolean, true if the text should be printed in reverse (white on black).
     * - `print.drawImage(bitmap: Bitmap, x: Int, y: Int)`: Draws a bitmap image on the current page. (Commented out in the original example)
     * - `print.roll(lines: Int)`: Feeds the paper by the specified number of lines. Used here to add space after printing.
     * - `print.printPage()`: Sends the current page data to the printer.
     *
     * How to print text:
     * 1. **Initialize the printer page:** Call `print.initPage()` to set the canvas size for printing.
     * 2. **Prepare the text and parameters:** Define the text string, coordinates (x, y), font size/style, and other formatting options.
     * 3. **Draw the text:** Call `print.drawText()` with the prepared parameters. You can call this multiple times to print different text elements or the same text with different styles.
     * 4. **Print the page:** Call `print.printPage()` to send the composed page to the printer.
     */
    fun printText() {
        // Initialize a print page with a height of 200 dots.
        // This value might need adjustment based on the amount of content and printer capabilities.
        print.initPage(200)

        val print_font = "PRINT TESTING"
        var currentYPosition = print_y // Start Y position for the first line of text

        // Example 1: Print standard text
        // x=0, y=currentYPosition, text=print_font, fontSize=print_y (36), fontStyle=1, bold=false, rotation=0f, underline=false, reverse=false
        print.drawText(print_x, currentYPosition, print_font, print_y, 1, false, 0f, false, false)
        currentYPosition += print_y // Increment Y position for the next line to avoid overlap

        // Example 2: Print bold text
        print.drawText(print_x, currentYPosition, print_font, print_y, 1, true, 0f, false, false)
        currentYPosition += print_y

        // Example 3: Print underlined text
        print.drawText(print_x, currentYPosition, print_font, print_y, 1, false, 0f, true, false)
        currentYPosition += print_y

        // Example 4: Print reversed text (white on black) - this might depend on printer capabilities
        print.drawText(print_x, currentYPosition, print_font, print_y, 1, false, 0f, false, true)
        currentYPosition += print_y

        // Example 5: Print bold and underlined text
        print.drawText(print_x, currentYPosition, "BOLD & UNDERLINED", print_y, 1, true, 0f, true, false)
        currentYPosition += print_y

        // Optional: Example of printing an image (if you have an image file)
        // Ensure you have a "test.jpg" file in the specified path or adjust the path.
        // Also, ensure your app has permissions to read from external storage if the file is there.
        // val imagePath = "/data/data/com.print_demo/files/test.jpg" // Example internal storage path
        // Or can load image from url and convert it to bitmap and use the below function
        // val imageBitmap = BitmapFactory.decodeFile(imagePath)
        // if (imageBitmap != null) {
        //     print.drawImage(imageBitmap, print_x, currentYPosition)
        //     currentYPosition += imageBitmap.height + 10 // Add some padding after the image
        // } else {
        //     print.drawText(print_x, currentYPosition, "Image not found", print_y, 1, false, 0f, false, false)
        //     currentYPosition += print_y
        // }

        // Send the composed page to the printer.
        print.printPage()

        // Feed the paper after printing to add some space for tearing.
        // The number of lines (e.g., 5) can be adjusted as needed.
        print.roll(5) // Feeds the paper by 5 lines
    }
}