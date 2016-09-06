import socket,threading, time


HOST='104.128.233.118'
PORT=9999

def create_server():
    s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    s.bind((HOST, PORT))
    s.listen(10)

    while True:
        print('waiting for connection')
        tcs, addr = s.accept()
        print('connected from:', addr)
        threading.Thread(target=send_message, args=(tcs, addr), daemon=True).start()
        

def send_message(tcs, addr):
    while True:
        try:
            print('send to', addr, ': 123456')
            tcs.send(b'123456')
            time.sleep(3)
        except Exception as err:
            print(addr, 'connect closed, reason:', err)
            tcs.close()
            break
        

if __name__ == '__main__':
    create_server()
