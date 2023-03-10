# π μ°Έκ³ μλ£

---

- Netty κ³΅μ μ¬μ΄νΈ β [**λ§ν¬**](https://netty.io/)

# βκ³΅λΆ λ΄μ© μ λ¦¬

---

## Nettyλ?

---

μ μ§ κ΄λ¦¬ κ°λ₯ν κ³ μ±λ₯ νλ‘ν μ½ μλ² λ° ν΄λΌμ΄μΈνΈμ μ μν κ°λ°μ μν,
λΉλκΈ° μ΄λ²€νΈ λλΌμ΄λΈ λ€νΈμν¬ μ νλ¦¬μΌμ΄μ νλ μμν¬μ΄λ€.

## μ’ λ μμΈν μμλ³΄μ

---

![components.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/38e4e730-f66c-403d-8a60-159715f8f32d/components.png)

- νλ‘ν μ½ μλ² λ° ν΄λΌμ΄μΈνΈμ κ°μ λ€νΈμν¬ μ νλ¦¬μΌμ΄μμ λΉ λ₯΄κ³  μ½κ² κ°λ° ν  μ μλ NIO ν΄λΌμ΄μΈνΈ μλ² νλ μμν¬
- TCP λ° UDP μμΌ μλ²μ κ°μ λ€νΈμν¬ νλ‘κ·Έλλ°μ ν¬κ² λ¨μννκ³  λ₯λ₯ ννλ€.
- FTP, SMTP, HTTP λ° λ€μν λ°μ΄λλ¦¬ λ° νμ€νΈ κΈ°λ° λ κ±°μ νλ‘ν μ½κ³Ό κ°μ λ§μ νλ‘ν μ½μ κ΅¬ννμ¬ μ»μ κ²½νμΌλ‘ μ μ€νκ² μ€κ³ λμλ€.

μ λ΄μ©μ λ³΄κ³  Nettyκ° κΈ°μ‘΄μ μλ λ€νΈμν¬ νλ‘κ·Έλλ°μ λ¬Έμ μ μ ν΄κ²°ν κ²μΌλ‘ λ³΄μΈλ€.

κ·Έκ² λ¬΄μμΈμ§ μμλ³΄μ.

## Nettyμ μ€κ³(Design) λ° νΌν¬λ¨Όμ€(Performance)

---

### μ€κ³(Design)

- λ€μν μ μ‘ μ νμ μν ν΅ν© API - Blocking and Non-Blocking Socket
- κ΄μ¬μ¬λ₯Ό λͺννκ² λΆλ¦¬ν  μ μλ μ μ°νκ³  νμ₯ κ°λ₯ν μ΄λ²€νΈ λͺ¨λΈμ κΈ°λ°μΌλ‘ νλ€.
- κ³ λλ‘ μ¬μ©μ μ μ κ°λ₯ν μ€λ λ λͺ¨λΈ - λ¨μΌ μ€λ λ, SEDAμ κ°μ νλ μ΄μμ μ€λ λ ν
- μ§μ ν λΉμ°κ²°ν(Connectionless) λ°μ΄ν°κ·Έλ¨(Datagram) μμΌ μ§μ(3.1λΆν°)

### νΌν¬λ¨Όμ€(Performance)

- μ²λ¦¬λ ν₯μ, λκΈ° μκ° λ¨μΆ(Low latency)
- μ μ μμ μλΉ
- λΆνμν λ©λͺ¨λ¦¬ λ³΅μ¬ μ΅μν

### μ€μν ν€μλ

- Non-blocking
    - blocking IOμ λΉν΄ μ²λ¦¬λμ΄ λλ€.
    - Non-Blocking IOλ₯Ό μ΄ν΄νλ κ²μ Nettyμ ν΅μ¬ κ΅¬μ± μμμ κ·Έ κ΄κ³λ₯Ό μ΄ν΄νλλ° μ€μ
- μ±λ(Channel)
    - Java NIOμ κΈ°λ°.
    - μ½κΈ° λ° μ°κΈ°μ κ°μ IO μμμ΄ κ°λ₯ν μ΄λ¦° μ°κ²°μ λνλΈλ€.
    - Java NIOμ λν κ³΅λΆκ° νμ(μλ°μ μ  μ±μ λμ€λ λ΄μ© κ³΅λΆ)

## Nettyλ₯Ό μ¬μ©νλ μ΄μ 

---

HTTP λλ FTPμ κ°μ λΆνμν μ€λ²ν€λ μμ΄ νΉμ  μκ΅¬μ¬ν­μ λ§κ² λ§μΆ€ν λ€νΈμν¬ νλ‘ν μ½μ μμ±νμ¬ νΉμ  μν©μ λ§κ² νΈλν½ νλ¦μ μ΅μ ν ν  μ μμ΅λλ€.

## μλ°μμ Nettyκ° νλ μΌ

---

Block λ° Non-blocking I/O, TCPμ κ°μ μ°κ²° μ§ν₯ νλ‘ν μ½ λ° UDPμ κ°μ λΉ μ°κ²° νλ‘ν μ½μ μ§μνκ³  ν΄λΌμ΄μΈνΈμ μλ² λͺ¨λμμ λ°μ΄ν° μ μ‘μ κ΄λ¦¬ν©λλ€.

# κ³΅λΆνλ©΄μ λλ μ 

---

# μλ° NIOλ₯Ό λ¨Όμ  κ³΅λΆ νκ³  κ·Έ λ€μμ λ΄μ©μ κΉκ² κ³΅λΆν΄λ³΄μ!!!!