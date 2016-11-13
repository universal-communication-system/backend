using System;
using System.IO;
using System.Net.Sockets;

namespace backend {
	public class ClientHandler {
		public TcpClient Client;
		public Stream Stream;
		public byte[] ReadBuffer;

		public void ReadCallback(IAsyncResult iar) {
			int len = Stream.EndRead(iar);
			FilteringStream.OnReceived(ReadBuffer, 0, len);
			Stream.BeginRead(ReadBuffer, 0, ReadBuffer.Length, ReadCallback, null);
		}

		public ClientHandler(IAsyncResult iar) {
			Client = MainClass.Listener.EndAcceptTcpClient(iar);
			Stream = Client.GetStream();
			ReadBuffer = new byte[4096];
			Stream.BeginRead(ReadBuffer, 0, ReadBuffer.Length, ReadCallback, null);
			FilteringStream.OnClientOpened(this);
		}
	}
}

