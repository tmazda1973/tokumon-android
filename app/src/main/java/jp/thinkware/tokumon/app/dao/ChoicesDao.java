package jp.thinkware.tokumon.app.dao;

import java.util.List;
import java.util.Map;

import jp.thinkware.tokumon.app.dto.ChoicesDto;

/**
 * DBレコードのDAOインターフェースクラスです。(選択肢テーブル)
 * @author thinkware
 */
public interface ChoicesDao {

	/**
	 * DBにレコードを新規追加します。
	 * @param dto データオブジェクト
	 * @return 行ID
	 */
	public Long insert(ChoicesDto dto);

	/**
	 * DBのレコードを更新します。
	 * @param dto データオブジェクト
	 * @return なし
	 */
	public void update(ChoicesDto dto);

	/**
	 * DBのレコードを削除します。
	 * @param dto データオブジェクト
	 * @return なし
	 */
	public void delete(ChoicesDto dto);

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
	public List<ChoicesDto> selectList(Map<String, Object> conditionMap);
}
