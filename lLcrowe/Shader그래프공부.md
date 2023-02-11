게임을 맛깔나게 만들기 위한 공부




비쥬얼이팩트그래프
https://unity.com/visual-effect-graph







Shader를 다루기

특정정점의 90도 구현
벡터는 0~1까지만 표현
DXT는 알파랑 따로
ASTC는 RGBA다 저장
노말맵은 픽셀단위로 달라짐
공간은 행럴로 표현
A B를 내적
유니티는 열기준행럴로 곱함
노멀/범프/하이트/디스
XYZW
XYZ 회전
A 이동 
유니티는 왼손 좌표계
두개의 벡터를 외적으로하면
나머지한개로 외적이 나옴
공간좌표축이 나올때 공간이 만들때 외적을 이용
탄젠트 좌표계
Binormal, BiTangent
BI => Binary
노말은 회전만 있으니까 
3X3으로 충분
MainLightDirection
Negate => 뒤집힘
TransForm노드에서 처리하게 할수 있음
WS=>월드스페이스
VS=>뷰스페이스
노멀이등 범프맵이든 기술은 똑같음
범프맵은 노멀맵으로 생각해도 됨
Cross => 외적
Dot=> 내적
S는 Space로 보면 된다 네이밍이 거의그럼
행렬을 가르키는 TS OS WS 
이득우
3D
깨공수학
수포자수학
노말맵에 대한 기초이론