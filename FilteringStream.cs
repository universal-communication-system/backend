using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.IO;

namespace backend {
	public static class FilteringStream {
		private static ProcessStartInfo Psi = new ProcessStartInfo();
		private static List<ClientHandler> Clients = new List<ClientHandler>();

		static FilteringStream() {
			Psi.FileName = "filter.sh";
			Psi.RedirectStandardError = false;
			Psi.RedirectStandardInput = true;
			Psi.RedirectStandardOutput = true;
			Psi.UseShellExecute = false;
		}

		public static void OnClientOpened(ClientHandler client) {
			Clients.Add(client);
		}

		public static void OnReceived(byte[] buf, int off, int len) {
			if ( len > 0 ) {
				using ( Process proc = Process.Start(Psi) ) {
					proc.StandardInput.BaseStream.Write(buf, off, len);
					proc.StandardInput.Close();
					proc.WaitForExit();
					byte[] output;
					using ( MemoryStream buffer = new MemoryStream() ) {
						proc.StandardOutput.BaseStream.CopyTo(buffer);
						output = buffer.ToArray();
					}
					foreach ( ClientHandler client in Clients.ToArray() ) {
						try {
							client.Stream.Write(output, 0, output.Length);
						} catch ( Exception ex ) {
							Console.Error.WriteLine(ex);
							Clients.Remove(client);
						}
					}
				}
				Console.OpenStandardOutput().Write(buf, off, len);
			}
		}
	}
}

