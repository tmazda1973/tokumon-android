package jp.thinkware.tokumon.app.dao;

import java.util.List;
import java.util.Map;

import jp.thinkware.tokumon.app.dto.AnswerSheetDto;

/**
 * DBレコードのDAOインターフェースクラスです。(解答用紙テーブル)
 * @author thinkware
 */
public interface AnswerSheetDao {

	/**
	 * DBにレコードを新規追加します。
	 * @param dto データオブジェクト
	 * @return 行ID
	 */
	public Long insert(AnswerSheetDto dto);

	/**
	 * DBのレコードを更新します。
	 * @param dto データオブジェクト
	 * @return なし
	 */
	public void update(AnswerSheetDto dto);

	/**
	 * DBのレコードを削除します。
	 * @param dto データオブジェクト
	 * @return なし
	 */
	public void delete(AnswerSheetDto dto);

	/**
	 * DBのレコードを削除します。
	 * @param conditionMap 抽出条件マップ
	 * @return なし
	 */
	public void delete(Map<String, Object> conditionMap);

	/**
	 * DBのレコードを抽出します。
	 * @param conditionMap 抽出条件マップ
	 * @return データリスト
	 */
	public List<AnswerSheetDto> selectList(Map<String, Object> conditionMap);

	/**
	 * 結合テーブルも含めてDBからレコードを抽出します。
	 * @param conditionMap 抽出条件マップ
	 * @return データオブジェクト
	 */
	public AnswerSheetDto selectWithJoin(Map<String, Object> conditionMap);

	/**
	 * 指定行のレコードを抽出します。
	 * @param rowId 行ID
	 * @return データオブジェクト
	 */
	public AnswerSheetDto selectRow(Long rowId);
}