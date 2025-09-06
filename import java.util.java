import java.util.Random;
import java.util.Scanner;
public class GoBackNSimulation {
static final int TOTAL_FRAMES = 10;
static final int WINDOW_SIZE = 4;
public static void main(String[] args) throws
InterruptedException {
Scanner sc = new Scanner(System.in);
Random rand = new Random();
int base = 0;
int nextFrame = 0;
while (base < TOTAL_FRAMES) {

while (nextFrame < base + WINDOW_SIZE && nextFrame <
TOTAL_FRAMES) {
System.out.println("Sender: Sending Frame " +
nextFrame);
nextFrame++;
}

for (int i = base; i < nextFrame; i++) {
Thread.sleep(1000); 
boolean ackLost = rand.nextInt(5) == 0;
if (ackLost) {
System.out.println("Receiver: Frame " + i + "
ACK lost or Frame corrupted!");
System.out.println("Sender: Timeout! Resending
from Frame " + i);
nextFrame = base = i; 
break;
} else {
System.out.println("Receiver: Frame " + i + "
received successfully.");
System.out.println("Sender: ACK " + i + "
received.");
base++;
}
}
}
System.out.println("\nAll frames sent successfully using Go-
Back-N!");
sc.close();
}
}