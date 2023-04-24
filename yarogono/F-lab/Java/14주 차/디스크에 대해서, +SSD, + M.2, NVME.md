# 🔗 참고자료

---

- 한 권으로 읽는 컴퓨터 구조와 프로그래밍 - 3장 메모리와 디스크의 핵심 : 순차 논리
    - 156p 블록 장치
    - 159p 플래시 메모리와 SSD
- chatGPT
- 다나와(danawa.com) ⇒ [**링크**](https://prod.danawa.com/info/?pcode=13562693#bookmark_product_information)

# ✏공부 내용 정리

---

![main-qimg-69a6693e582e8b506cca7ef0e23fcf12-c.jpg](https://file.notion.so/f/s/fd2f9a93-2b45-4465-9c49-c8f2c904f2d5/main-qimg-69a6693e582e8b506cca7ef0e23fcf12-c.jpg?id=e4ed1ac9-eed7-4fe5-bae5-44cd586a1ac5&table=block&spaceId=a6996cfb-7419-48fb-9ad1-d4bdae0c3162&expirationTimestamp=1682431676046&signature=ktFD9qAJji5p3zgjKXPfJ91RuJyoUJCEYNLUY7wPQmw&downloadName=main-qimg-69a6693e582e8b506cca7ef0e23fcf12-c.jpg)

## ❓디스크 드라이브란?

대량 저장장치(mass storage)로 엄청나게 많은 데이터를 저장하기 아주 좋은 장치다.

- 중화 요리집 식탁 중간에 있는 회전판과 비슷한 자화원판(platter)에 비트를 저장한다.
- 디스크의 영역을 자화시켜서 데이터를 저장한다 ⇒ **비 휘발성(Non volatile)**

### 디스크 드라이브의 단점

- 다른 유형의 메모리에 비해 상대적으로 느리다.
    - 방금 헤드를 지나간 데이터가 필요한 경우 그 데이터를 읽을 수 있으려면 회전판이 거의 1바퀴 돌 때까지 기다려야 한다.
- 기계 부품이 시간이 지나면서 낡아진다.
    - 회전축의 마찰을 줄여주는 베어링의 마모는 디스크 오류를 일으키는 주 원인
      ETC) 기업용 디스크와 일반인용 디스크의 차이는 주로 베어링에 들어있는 윤활유 양의 차이다.

### 디스크 드라이브는 기록 밀도와 속도를 맞바꾼 장치다

디스크 드라이브는 헤드 아래 원하는 비트가 돌아올 때 까지 시간이 걸리기 때문에 느리다.

⇒ 하지만 DRAM 등과 달라 주소나 데이터 연결을 위한 공간이 필요 없다.

### 디스크는 블록 단위로 주소를 지정해 읽는다

디스크는 바이트 단위로 주소를 지정해 읽는 대신 블록 단위로 주소를 지정해 읽는다.

- **블록(block)**은 역사적으로 **섹터(sector)**라고 불러 왔다.
    - 디스크에서 읽고 쓰기가 가능한 가장 작은 단위다.


디스크에 한 바이트만 바꾸고 싶으면 전체 블록을 읽고 원하는 바이트를 바꾼 다음 전체 블록을 다시 써야 한다.

⇒ 섹터당 저장하는 바이트 수가 정해져 있다.

![Untitled](https://file.notion.so/f/s/43545089-474d-49e2-9d48-b2ef4ae62e99/Untitled.png?id=2920ae5a-b341-4f87-9e73-7c67d4a1ec50&table=block&spaceId=a6996cfb-7419-48fb-9ad1-d4bdae0c3162&expirationTimestamp=1682431692716&signature=HolmQOs6_xing8ttgfV5GJ-eGZrKmmskAarbhf2ijOw&downloadName=Untitled.png)

- 모든 섹터에 같은 수의 비트가 있기 때문에 bit/mm2으로 표현하는 비트 밀도(bit density)는 각 원판의 바깥쪽보다 안쪽이 더 높다.
- 바깥쪽 트랙에는 비트를 더 집어넣을 수 있는 여유가 많기 때문에 이런 방식은 낭비가 심하다.
    - 이 문제를 방사상 영역(radial zone)으로 구분해 해결
        - 내부 영역보다 외부에 더 많은 섹터가 들어간다.

![Untitled](https://file.notion.so/f/s/aec7f9ec-ba40-4e8d-8f5a-eac0d1cbaa20/Untitled.png?id=7a4eb378-0cef-47c1-aa14-7f9f3bfe3847&table=block&spaceId=a6996cfb-7419-48fb-9ad1-d4bdae0c3162&expirationTimestamp=1682431705515&signature=HX4gjoUS6lNEOJg4dkszUA_JKpM5uVS1zuUnOOff62U&downloadName=Untitled.png)

## ❓SSD란?

고체 상태 드라이브(Solid-State Drive)로, 디스크 드라이브 모양의 패키지에 넣은 플래시 메모리와 같다.

- SSD에는 여러 블록의 쓴 횟수를 기억해서 모든 블록이 가능하면 똑같은 수준으로 낡도록 조성(wear leveling)하는 프로세서가 들어 있다.


![Untitled](https://file.notion.so/f/s/94fd98e0-e4cc-4287-b649-c251cc174605/Untitled.png?id=9236a9a7-a14c-44c2-9f8f-120c32fa946a&table=block&spaceId=a6996cfb-7419-48fb-9ad1-d4bdae0c3162&expirationTimestamp=1682431732092&signature=HDflR2zQWbEC1NERsKGp4PoH8yxHNCTRn1f8KRzuvi4&downloadName=Untitled.png)

### ❓플레시 메모리란?

가장 최근 나타난 EEPROM 유형의 매체로, 음악 플레이어나 디지털 카메라 등의 응용에는 플래시 메모리가 적합하다.

- DRAM과 마찬가지로 버킷에 전자를 담는 방식으로 작동
    - 하지만 플래시 메모리의 버킷은 DRAM 보다 더 크고 잘 만들어져 전자가 새지 않는다
        - 하지만 여러번 읽고 쓰기 위해 뚜껑을 여닫다 보면 뚜껑의 경첩이 닳아서 끊어져 버린다.
- 플래시 메모리는 RAM처럼 원하는 위치를 마음대로 읽을 수 있다.
    - 하지만 빈 플래시 메모리에 데이터를 기록하기 위해서는 먼저 0을 채워 넣어야 한다.
        - 0을 1로 바꿀 수는 있지만, 전체를 지우지 않고 원하는 비트만 0으로 되돌릴 수는 없다.
        - 모든 메모리를 지우는 것은 낭비가 심해 블록 단위로 나눠 지우거나 쓴다.
- 읽을 때는 임의 접근 장치(Random access)이고, 쓸때는 블록 접근 장치(block access)다.

![Untitled.png](https://file.notion.so/f/s/fd7a196b-4a9f-4e23-9b5f-983ae2ad4561/Untitled.png?id=8eb2c9d7-1dbd-4ec7-a0be-a517e12b007c&table=block&spaceId=a6996cfb-7419-48fb-9ad1-d4bdae0c3162&expirationTimestamp=1682431749682&signature=RVcxOTJjM-7jNLd-ctT69VzPdNIK_HQGRkUdXB03_4A&downloadName=Untitled.png)

## ❓M.2란?

M.2는 NGFF(Next Generation FormFactor)의 다른 명칭으로 기판 양면에 낸드 플래시를 붙일 수 있으며, PCI Express x2나 PCI Express x4에 직접 연결하여 최대 10Gb/s의 대역폭을 제공할 수 있는 폼펙터입니다.

- 컴퓨터에서 사용되는 작은 포맷의 저장장치
- SATA  또는 PCIe 인터페이스를 사용한다
- M.2 슬롯은 최근 컴퓨터 메인보드에서 많이 사용되고 있으며, 노트북, 태블릿 등의 모바일 장치에서도 사용된다.
- 주로 운영 체제, 프로그램, 게임 등을 저장하는 용도로 사용된다.
- 일부 M.2 드라이브는 내장 그래픽 카드와 함께 사용하여 성능을 높일 수도 있다.

![Untitled](https://file.notion.so/f/s/d621c5b0-e845-4f93-be9f-3e191d7828e4/Untitled.png?id=bf7ed73f-fb88-48ec-ab61-6aad87fcb5fe&table=block&spaceId=a6996cfb-7419-48fb-9ad1-d4bdae0c3162&expirationTimestamp=1682431876154&signature=XRUwhIkuTX_0jKpz2Dv0so_t2GSpiL64dsJ62b-9Dg0&downloadName=Untitled.png)

## ❓NVMe란?

Non-Volatile Memory Express의 약자로, 플래시 메모리를 기반으로하는 저장 장치를 위한 표준 인터페이스이다.

- 기존의 AHCI(Advanced Host Controller Interface) 인터페이스보다 더 높은 속도와 성능을 제공하며, SSD에서의 지연 시간과 대기 시간을 크게 줄일 수 있다.
- NVMe 인터페이스를 사용하는 M.2 SSD 및 PCIe SSD등은 높은 전송 속도와 대기 시간이 짧은 I/O 작업을 수행할 수 있어, 일반적인 SATA 인터페이스를 사용하는 SSD보다 훨씬 바르다.
    - 이는 더욱 빠른 부팅 시간, 애플리케이션 로딩 시간 및 파일 전송 시간 등을 제공한다.

## 궁금한 점

- EFFPROM이란?

  해당 내용에 대해 정리된 블로그 ⇒ [**링크**](https://m.blog.naver.com/southpowers/221412059893)

- DRAM이 무엇이고, 플래시 메모리와 DRAM에서의 뚜껑이란?
    - 해당 내용에 대해 정리된 블로그 ⇒ [**링크**](https://techblog-history-younghunjo1.tistory.com/505)
- 컴퓨터 인터페이스란?
    - 하드웨어나 소프트웨어 간의 상호 작용을 가능하게 해주는 수단
    - 저장 장치와 컴퓨터의 상호작용을 위해서는 인터페이스가 필요하며, 이 인터페이스를 통해 데이터를 주고 받게 된다.
    - NVMe는 저장 장치와 컴퓨터 간의 인터페이스 중 하나 이다.