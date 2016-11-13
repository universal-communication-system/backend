using System;
using System.Net;
using System.Net.Sockets;
using System.Threading;

namespace backend {
	class MainClass {
		public static TcpListener Listener;

		public static void AcceptCallback(IAsyncResult iar) {
			new ClientHandler(iar);
			Listener.BeginAcceptTcpClient(AcceptCallback, null);
		}

		public static void Main(string[] args) {
			Listener = new TcpListener(IPAddress.Any, 1123);
			Listener.Start();
 			Listener.BeginAcceptTcpClient(AcceptCallback, null);
			Thread.Sleep(int.MaxValue);
		}
	}
}
