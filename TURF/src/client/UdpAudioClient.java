package client;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;

public class UdpAudioClient {

	private AudioInputStream audioInputStream;
	private SourceDataLine sourceDataLine;

	public UdpAudioClient() {
		// TODO Auto-generated constructor stub
		initiateAudio();
	}

	private void initiateAudio() {
		// TODO Auto-generated method stub
		try {
			DatagramSocket socket = new DatagramSocket(9786);
			byte[] audioBuffer = new byte[10000];
			while (true) {
				DatagramPacket packet = new DatagramPacket(audioBuffer, audioBuffer.length);
				socket.receive(packet);

				byte audioData[] = packet.getData();
				InputStream byteInputStream = new ByteArrayInputStream(audioData);
				AudioFormat audioFormat = getAudioFormat();
				audioInputStream = new AudioInputStream(byteInputStream, audioFormat,
						audioData.length / audioFormat.getFrameSize());
				DataLine.Info dataLineInfo = new DataLine.Info(SourceDataLine.class, audioFormat);

				sourceDataLine = (SourceDataLine) AudioSystem.getLine(dataLineInfo);
				sourceDataLine.open(audioFormat);
				sourceDataLine.start();
				playAudio();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private AudioFormat getAudioFormat() {
		float sampleRate = 16000F;
		int sampleSizeInBits = 16;
		int channels = 1;
		boolean signed = true;
		boolean bigEndian = false;
		return new AudioFormat(sampleRate, sampleSizeInBits, channels, signed, bigEndian);
	}

	private void playAudio() {
		// TODO Auto-generated method stub
		byte[] buffer = new byte[10000];
		try {
			int count;
			while ((count = audioInputStream.read(buffer, 0, buffer.length)) != -1) {
				if (count > 0) {
					sourceDataLine.write(buffer, 0, count);
				}
			}
		} catch (Exception e) {
			// Handle exceptions
		}
	}

	public static void main(String[] args) {
		new UdpAudioClient();
	}

}
