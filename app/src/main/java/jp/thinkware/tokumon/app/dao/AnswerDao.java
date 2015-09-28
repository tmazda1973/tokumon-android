package jp.thinkware.tokumon.app.dao;

import java.util.List;
import java.util.Map;

import jp.thinkware.tokumon.app.dto.AnswerDto;

/**
 * DBレコードのDAOインターフェースクラスです。(解答テーブル)
 * @author thinkware
 */
public interface AnswerDao {

	/**
	 * DBにレコードを新規追加します。
	 * @param dto データオブジェクト
	 * @return 行ID
	 */
	public Long insert(AnswerDto dto);

	/**
	 * DBのレコードを更新します。
	 * @param dto データオブジェクト
	 */
	public void update(AnswerDto dto);

	/**
	 * DBのレコードを削除します。
	 * @param dto データオブジェクト
	 */
	public void delete(AnswerDto dto);

	/**
	 * DBのレコードを削除します。
	 * @param conditionMap 抽出条件マップ
	 */
	public void delete(Map<String, Object> conditionMap);

	/**
	 * DBのレコードを抽出します。
	 * @param conditionMap 抽出条件マップ
	 * @return データリスト
	 */
	public List<AnswerDto> selectList(Map<String, Object> conditionMap);

	/**
	 * 結合テーブルも含めてDBからレコードを抽出します。
	 * @param conditionMap 抽出条件マップ
	 * @return データオブジェクト
	 */
	public AnswerDto selectWithJoin(Map<String, Object> conditionMap);
}
