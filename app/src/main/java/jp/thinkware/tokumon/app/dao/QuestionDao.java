package jp.thinkware.tokumon.app.dao;

import java.util.List;
import java.util.Map;

import jp.thinkware.tokumon.app.dto.QuestionDto;

/**
 * DBレコードのDAOインターフェースクラスです。(設問テーブル)
 * @author thinkware
 */
public interface QuestionDao {

	/**
	 * DBにレコードを新規追加します。
	 * @param dto データオブジェクト
	 * @return 行ID
	 */
	public Long insert(QuestionDto dto);

	/**
	 * DBのレコードを更新します。
	 * @param dto データオブジェクト
	 * @return なし
	 */
	public void update(QuestionDto dto);

	/**
	 * DBのレコードを削除します。
	 * @param dto データオブジェクト
	 * @return なし
	 */
	public void delete(QuestionDto dto);

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
	public List<QuestionDto> selectList(Map<String, Object> conditionMap);

	/**
	 * DBのレコードを抽出します。(抽出件数指定あり)
	 * @param conditionMap 抽出条件マップ
	 * @return データリスト
	 */
	public List<QuestionDto> selectList(Map<String, Object> conditionMap, long limitCount);

	/**
	 * 結合テーブルも含めてDBからレコードを抽出します。
	 * @param conditionMap 抽出条件マップ
	 * @return データオブジェクト
	 */
	public QuestionDto selectWithJoin(Map<String, Object> conditionMap);

}