# 🔗 참고자료

---

- git merge 한 번에 정리하기 : Fast Forward Merge, Commit Merge, Conflict Merge ⇒ ****[링크](https://kotlinworld.com/277)**
- Git Basics: Merge and Rebase ⇒ ****[링크](https://www.youtube.com/watch?v=dO9BtPDIHJ8&ab_channel=EnvatoTuts%2B)****
- Git Merge와 Rebase의 차이, 아름다운고 깔끔한 Git History 만들기. ⇒ **[링크](https://firework-ham.tistory.com/12)**

# ✏공부 내용 정리

---

![git_merge_rebase.jpeg](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/1fec1f7f-a32f-4a0c-9ce2-3006b6d21c2f/git_merge_rebase.jpeg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230324%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230324T130148Z&X-Amz-Expires=86400&X-Amz-Signature=18be2e6b41eaa9737996a6671c4d219912ace0630b3d856cea00507166d05510&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22git_merge_rebase.jpeg%22&x-id=GetObject)

## Merge와 Rebase 의 차이

둘다 다른 브랜치와 합치는 방법인 것은 같습니다.

하지만 Merge는 현재 브랜치와 다른 브랜치를 병합하면서 새로운 커밋을 만들고,

rebase는 다른 브랜치에서 현재 브랜치로 변경 사항을 가져와서, 현재 브랜치의 커밋 히스토리를 재작성합니다.

## Merge(머지)

- 두 개의 브랜치를 병합할 때 사용하는 명령어
- 두 브랜치의 작업 내용을 결합하고 병합 커밋을 생성합니다.
- 병합 커밋은 작업 이력에 포함되며, 각 브랜치의 이력을 보존합니다.

## Rebase(리베이스)

- 두 개의 브랜치를 병합할 때 사용하는 명령어
- 현재 브랜치를 대상 브랜치의 끝에 붙이는 방법
