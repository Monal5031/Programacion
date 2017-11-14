import matplotlib.pyplot as plt


if __name__ == '__main__':
    f = open("output.txt", 'r')
    #
    # a = f.readline()
    # b = f.readline()
    # print(a)
    # print(b)
    # x = a.split()
    # y = b.split()
    # for i in range(len(x)):
    #     x[i] = float(x[i])
    # for i in range(len(y)):
    #     y[i] = float(y[i]);
    # print(x);
    # print(y);
    #
    # plt.plot(x,y)
    # plt.show()
    #
    # f.close()



    quant = []
    avgW = []
    avgTaT = []
    #print(f.readline())
    while True:
        t = f.readline()
        #print(t)

        if t is "":
            break
        a,b,c = map(float, t.split())
        quant.append(int(a))
        avgW.append(b)
        avgTaT.append(c)
    f.close()


    # print(quant)
    # print(avgTaT)
    # print(avgW)
    fig = plt.figure(1)
    fig.subplots_adjust(hspace=.5)
    ax1 = plt.subplot(211)
    ax1.set_title("quantum vs average waiting time")
    plt.plot(quant, avgW, 'bo')


    ax2 = plt.subplot(212)
    ax2.set_title("quantum vs average turn around time")
    plt.plot(quant, avgTaT, 'bo')
    plt.show()